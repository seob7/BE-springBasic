package SEOB.SEOB.service;

import SEOB.SEOB.discount.DiscountPolicy;
import SEOB.SEOB.discount.FixDiscountPolicy;
import SEOB.SEOB.domain.GradeType;
import SEOB.SEOB.domain.Member;
import SEOB.SEOB.domain.Order;
import SEOB.SEOB.repository.MemberRepository;
import SEOB.SEOB.repository.MemoryMemberRepository;
import SEOB.SEOB.repository.MemoryProductRepository;
import SEOB.SEOB.repository.ProductRepository;


public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountedPolicy = new FixDiscountPolicy();
    public Order createOrder(Long memberId, String name, int price) {
        Member member = memberRepository.findById(memberId);
        int discountedPrice = discountedPolicy.discount(member, price);
        return new Order(memberId, name, price, discountedPrice);
    }


}
