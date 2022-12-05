package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {
    MemberRepository repo = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        repo.clearStore();
    }

    @Test
    public void save() {
        // arrange
        Member member = new Member("hello", 20);
        // action
        repo.save(member);
        // assert
        Member findMember = repo.findById(member.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void findAll() {
        // arrange
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        repo.save(member1);
        repo.save(member2);
        // action
        List<Member> all = repo.findAll();
        // assert
        assertThat(all).hasSize(2);
        assertThat(all).containsExactlyInAnyOrder(member1, member2);
    }
}