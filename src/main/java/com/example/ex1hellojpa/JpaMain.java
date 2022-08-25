package com.example.ex1hellojpa;

import com.example.ex1hellojpa.member.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            final Member member = new Member(1L, "HelloJPA");

            final List<Member> resultList = entityManager.createQuery("select m from Member as m", Member.class).getResultList();
            for (Member result : resultList) {
                System.out.println("result = " + result);
            }
            System.out.println("BEFORE");
            entityManager.persist(member);
            System.out.println("AFTER");

            transaction.commit();
        } catch (final Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
