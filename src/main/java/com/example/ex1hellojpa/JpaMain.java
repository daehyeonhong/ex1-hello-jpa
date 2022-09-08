package com.example.ex1hellojpa;

import com.example.ex1hellojpa.member.Member;
import com.example.ex1hellojpa.member.Team;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Slf4j
public class JpaMain {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            final Team team = new Team();
            team.setName("TeamA");
            entityManager.persist(team);

            final Member member = new Member();
            member.setName("member1");
            member.setTeam(team);

            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            final Member findMember = entityManager.find(Member.class, member.getId());
            final List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                log.info("member : {}", m);
            }
            transaction.commit();
        } catch (final Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
