package hello.itemservice.repository;

import hello.itemservice.domain.Item;

import java.util.concurrent.ConcurrentHashMap;

public class MemoryItemRepository implements ItemRepository{
    private static ConcurrentHashMap<Long, Item> store = new ConcurrentHashMap<>();

    private static long SEQUENCE = 0L;

    //상품 등록 (상품명, 가격, 수량)
    public void save(Item item) {
        item.setItemId(++SEQUENCE);
        store.put(item.getItemId(), item);
    }

    //상품 상세
    public Item findByItemId(Long itemId) {
        return store.get(itemId);
    }
}