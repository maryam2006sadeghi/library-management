package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String, Member> customHashMap;

    public MemberManager() {
        customHashMap = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        customHashMap.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return customHashMap.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = customHashMap.get(memberId);
        member.addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = customHashMap.get(memberId);
        return member.getLastTransaction();
    }
}
