package com.example.ex1hellojpa;

import com.example.ex1hellojpa.member.Member;
import com.example.ex1hellojpa.member.Team;
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
            final Team team = new Team();
            team.setName("TeamA");
            entityManager.persist(team);

            final Member member = new Member();
            member.setName("member1");
            member.setTeamId(team.getId());

            entityManager.persist(member);

            final Member findMember = entityManager.find(Member.class, member.getId());
            final Long findMemberTeamId = findMember.getTeamId();
            final Team findTeam = entityManager.find(Team.class, findMemberTeamId);
            transaction.commit();
        } catch (final Exception exception) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
