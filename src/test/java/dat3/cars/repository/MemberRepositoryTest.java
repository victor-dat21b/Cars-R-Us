package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @BeforeAll
    public static void memberSetup(@Autowired MemberRepository memberRepository){
        memberRepository.deleteAll();
        //Kan være en fordel at slette alle hvis man ikke vil køre det på alle tests.
        Member member1 = new Member("user4", "passwordUsedByAll", "user4@a.dk", "Jens", "Hansen", "Elmegade", "København", "2100");
        memberRepository.save(member1);
    }


    @Test
    public void memberTest(){
        assertNotNull(memberRepository.findAll());
    }

}