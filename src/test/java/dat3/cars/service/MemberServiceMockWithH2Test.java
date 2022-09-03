package dat3.cars.service;

import dat3.cars.entity.Member;
import dat3.cars.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



//Mock with H2. Using H2 to explain another way instead of mocking database with @Mock.
@DataJpaTest
class MemberServiceMockWithH2Test {

    public  MemberService memberService;

    public static MemberRepository memberRepository;

    @BeforeAll
    public static void setupData(@Autowired MemberRepository member_Repository){
        memberRepository = member_Repository;
        List<Member> members = List.of(
                new Member("m1", "pw", "m1@a.dk", "Jens", "Jensen","Elmegade", "København", "2100" ),
                new Member("m2", "pw", "mm@a.dk", "Berit", "Jensen", "Elmegade", "København", "2100")
        );
        memberRepository.saveAll(members);
    }



    @BeforeEach
    public void setMemberService(){
        memberService = new MemberService(memberRepository);
    }



    @Test
    void findMembers() {
    }

    @Test
    void addMember() {
    }

    @Test
    void findMemberByUsername() {
    }
}