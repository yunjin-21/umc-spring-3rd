package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;
    public void save(Member member) {
        em.persist(member);
    } //jpa가 멤버 저장
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    } //멤버찾아서 반환
    public List<Member> findAll() { //list로 회원 목록 조회
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    public List<Member> findByName(String name) {  //list 로 회원목록 이름으로 조회
        return em.createQuery("select m from Member m where m.name = :name",  //jpql 엔티티객체에 대한
                        Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
