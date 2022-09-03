package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @BeforeEach
    public static void memberSetup(@Autowired MemberRepository memberRepository){
        memberRepository.deleteAll();
        //Kan være en fordel at slette alle hvis man ikke vil køre det på alle tests.
        Member member1 = new Member("m1", "pw", "m1@a.dk", "Jens", "Jensen","Elmegade", "København", "2100" );
        Member member2 = new Member("m2", "pw", "mm@a.dk", "Berit", "jOHN", "Elmegade", "København", "2100");
        Member member3= new Member("m3", "pw", "mmM@a.dk", "bENT", "bØRGE", "Elmegade", "Roskilde", "2100");
        Member member4= new Member("m4", "pw", "mmM4@a.dk", "Hans", "Brian", "Elmegade", "Roskilde", "2100");
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
    }


    @Test
    public void memberTest(){
        assertNotNull(memberRepository.findAll());
    }

}