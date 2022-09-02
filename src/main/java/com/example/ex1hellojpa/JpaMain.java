package com.example.ex1hellojpa;

import com.example.ex1hellojpa.member.Member;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
public class JpaMain {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            final Member member1 = new Member();
            member1.setName("감자");
            final Member member2 = new Member();
            member2.setName("고구마");
            final Member member3 = new Member();
            member3.setName("김치");
            log.info("======================");
            log.info("member1 : {}", member1);
            log.info("member2 : {}", member2);
            log.info("member3 : {}", member3);
            entityManager.persist(member1);
            entityManager.persist(member2);
            entityManager.persist(member3);
            log.info("======================");
            log.info("member1 : {}", member1);
            log.info("member2 : {}", member2);
            log.info("member3 : {}", member3);
            transaction.commit();
        } catch (final Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
