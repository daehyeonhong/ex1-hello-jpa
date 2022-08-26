package com.example.ex1hellojpa;

import com.example.ex1hellojpa.member.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            final Member member = new Member(200L, "member200");
            entityManager.persist(member);
            entityManager.flush();
            System.out.println("=============================");
            transaction.commit();
        } catch (final Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
