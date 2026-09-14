import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class Main {

	public static void main(String[] args) {
System.out.println("جاري محاولة الاتصال...");
        
        // استخدام اسم الـ persistence-unit الموجود في ملف persistence.xml
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskFlowPU");
             EntityManager em = emf.createEntityManager()) {
            
            System.out.println("✅ تم الاتصال بقاعدة البيانات H2 عبر Hibernate بنجاح!");
            
        } catch (Exception e) {
            System.err.println("❌ فشل الاتصال بقاعدة البيانات!");
            e.printStackTrace();
        }

	}

}
