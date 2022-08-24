package com.example.ex1hellojpa;

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
            final Member member = new Member();
            entityManager.persist(member);
            transaction.commit();
            final Member findMember = entityManager.find(Member.class, 1L);
            System.out.println("findMember = " + findMember);
            final List<Member> members = entityManager.createQuery("select m from Member as m", Member.class).getResultList();
            for (Member memberInfo : members) {
                System.out.println("memberInfo = " + memberInfo);
            }
        } catch (final Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
