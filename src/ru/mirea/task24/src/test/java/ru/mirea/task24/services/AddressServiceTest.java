package ru.mirea.task24.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.task24.repositories.AddressRepository;
import ru.mirea.task24.tables.Address;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class AddressServiceTest {
    
    @Mock
    private AddressRepository addressesRepository;
    private AddressService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new AddressService(addressesRepository);
    }

    @Test
    void createEntity() {
        Address addresses = new Address();
        addresses.setText("Moscow, street Lenina");

        underTest.createEntity(addresses);

        ArgumentCaptor<Address> addressesArgumentCaptor =
                ArgumentCaptor.forClass(Address.class);

        Mockito.verify(addressesRepository).save(addressesArgumentCaptor.capture());

        Address addressesArgumentCaptorValue = addressesArgumentCaptor.getValue();
        Assertions.assertThat(addressesArgumentCaptorValue).isEqualTo(addresses);
    }

    @Test
    void readAllEntity() {
        Address addresses1 = new Address();
        addresses1.setText("Moscow, street Karla Marksa");
        Address addresses2 = new Address();
        addresses2.setText("St. Peterburg, street Lenina");

        Mockito.when(addressesRepository.findAll()).thenReturn(List.of(addresses1, addresses2));

        List<Address> expected = underTest.readAllEntity();

        Mockito.verify(addressesRepository).findAll();
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(2);
        assertThat(expected.get(0).getText()).isEqualTo("Moscow, street Karla Marksa");
        assertThat(expected.get(1).getText()).isEqualTo("St. Peterburg, street Lenina");
    }

    @Test
    void deleteEntities() {
        Address addresses = new Address();
        addresses.setText("London");

        underTest.deleteAllEntity();

        Mockito.verify(addressesRepository).deleteAll();
    }

    @Test
    void filterAddressByText() {
        Address addresses1 = new Address();
        addresses1.setText("Yegoryevsk, street Pobeda");
        Address addresses2 = new Address();
        addresses2.setText("Berlin");

        Mockito.when(addressesRepository.findAllByText(addresses1.getText())).thenReturn(List.of(addresses1));

        List<Address> expected = underTest.filterBy(addresses1.getText(), null);

        Mockito.verify(addressesRepository).findAllByText(addresses1.getText());
        assertThat(expected).isNotNull();
        assertThat(expected.size()).isEqualTo(1);
        assertThat(expected.get(0).getText()).isEqualTo("Yegoryevsk, street Pobeda");
    }
}