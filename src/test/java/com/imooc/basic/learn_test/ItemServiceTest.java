package com.imooc.basic.learn_test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 如果从存储层查询到一个Item, 那么它的 name 将被转化为大写.
     */
    @Test
    public void shouldReturnItemNameInUpperCase() {

        // Given
        Item mockedItem = new Item("it1", "Item 1", "This is item 1", 2000, true);
        when(itemRepository.findById("it1")).thenReturn(mockedItem);

        // When
        String result = itemService.getItemNameUpperCase("it1");

        // Then
        verify(itemRepository, times(1)).findById("it1");
        assertThat(result).isEqualTo("ITEM 1");
    }
}
