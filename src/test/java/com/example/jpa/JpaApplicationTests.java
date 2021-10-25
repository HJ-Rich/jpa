package com.example.jpa;

import com.example.jpa.entity.Student;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JpaApplicationTests {

    @Test
    void contextLoads() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("week3_rich"); // classpath:resources/META-INF/persistence.xml 파일에서 week3_rich 이름으로 저장된 설정값을 통해 EMF 생성. 애플리케이션 전체에서 하나로 공유.
        EntityManager em = emf.createEntityManager(); // EMF을 통해 EM 생성. 트랜잭션 단위마다 EM을 생성해서 사용해야함.
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 관리를 위해 ET 생성

        try {
            tx.begin(); // 트랜잭션 시작

            // 1. id가 1, name이 richard인 entity 조회 테스트
            Student student = em.find(Student.class, 1L);
            System.out.println("\n\n");
            System.out.println("student = " + student.getName());
            assertThat(student.getName()).isEqualTo("richard");

            // 2. name을 richard2로 수정 테스트
            student.setName("richard2");
            System.out.println("\n\n");
            System.out.println("student = " + student.getName());
            tx.commit(); // commit 시점에 영속성 컨텍스트 내 관리되는 객체의 수정여부를 확인하고 update 쿼리를 전송한다.
            assertThat(em.find(Student.class, 1L).getName()).isEqualTo("richard2");

            tx.begin();

            // 3. 신규 생성 테스트
            Student newbie = new Student(); // 비영속 상태(new / transient)
            newbie.setName("I am newbie!");
            System.out.println("before persiste");
            System.out.println("newbie.getId() = " + newbie.getId());

            em.persist(newbie); // 영속 상태 (managed) - 커밋 전엔 seq값만 세팅해둔다.
            // 신규 영속 상태 생성. 1차캐시 저장과 함께 쓰기 지연 저장소에 쿼리가 보관됨.
            System.out.println("after persist");
            System.out.println("newbie.getId() = " + newbie.getId());

            // DB에서 조회한 게 아니라 1차캐시에서 조회해오는 것이므로 쿼리가 발생하지 않음
            Student student1 = em.find(Student.class, newbie.getId());

            // 커밋 시점에 쓰기 지연 저장소에 보관되어 있던 쿼리가 전송됨. (flush)
            tx.commit();

            // 1차 캐시를 통해 == 비교가 가능함.
            Student student2 = em.find(Student.class, student1.getId());
            System.out.println("student2.toString() = " + student2.toString());
            System.out.println("student1.toString() = " + student1.toString());
            
            assertThat(newbie == student1).isTrue();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
