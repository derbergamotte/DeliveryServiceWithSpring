package main;

import dto.ClientDto;
import dto.ProductDto;
import dto.StorageDto;
import dto.StoreDto;
import implementation.*;
import interfaces.*;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
//    public static void main(String[] args) {
//        //Create some objects
//        UtilClassForCreateSomeObjects.create();
//
//        ClientService clientService = ClientServiceImpl.getClientService();
//        StoreService storeService = StoreServiceImpl.getStoreService();
//        StorageService storageService = StorageServiceImpl.getStorageService();
//        ProductService productService = ProductServiceImpl.getProductService();
//        OrderService orderService = OrderServiceImpl.getOrderService();
//
//        System.out.println("Create client");
//        clientService.add("Gosha", "Zavadskogo", "777-33-12");
//        System.out.println(clientService.getById(3L));
//
//        System.out.println("Change him");
//        ClientDto clientDto = clientService.getById(3L);
//        clientDto.setName("Not Gosha");
//        clientService.update(clientDto);
//        System.out.println(clientService.getById(3L));
//
//        System.out.println("Create store");
//        storeService.add("The Best store in the world", "Serpukhova", "714-21-99");
//        System.out.println(storeService.getById(3L));
//
//        System.out.println("Now update");
//        StoreDto storeDto = storeService.getById(3L);
//        storeDto.setName("The worst store in the world");
//        storeService.update(storeDto);
//        System.out.println(storeService.getById(3L));
//
//        System.out.println("Create product");
//        Collection<Long> categories = new ArrayList<>();
//        categories.add(1L);
//        Collection<String> attributes = new ArrayList<>();
//        attributes.add("Halloween");
//        attributes.add("Yellow");
////        productService.add("Pumpkin", categories, attributes, "Just pumpkin");
//        System.out.println(productService.getById(3L));
//
//        System.out.println("Update");
//        ProductDto productDto = productService.getById(3L);
//        productDto.setInformation("Yellow pumpkin");
//        productService.update(productDto);
//        System.out.println(productService.getById(3L));
//        System.out.println("Let's peek that in the second category");
//        System.out.println(productService.getByCategoryById(2L));
//        System.out.println("And find something by attributes");
//
//        Collection<Long> attributesId = new ArrayList<>();
//        attributesId.add(1L);
//        attributesId.add(2L);
//        System.out.println(productService.findByAttributes(attributesId));
//        System.out.println("or attribute");
////        System.out.println(productService.findByAttributes(3L));
//
//        System.out.println("Let's put pumpkin in some stores");
//        storageService.add(1L, 3L, 120, 1200);
//        System.out.println("check");
//        System.out.println(storageService.getById(1L));
//        storageService.add(2L, 3L, 80, 1030);
//        System.out.println(storageService.getById(2L));
//        storageService.add(3L, 3L, 100, 1300);
//        System.out.println(storageService.getById(3L));
//        System.out.println("We have made a mistake");
//        StorageDto storageDto = storageService.getById(3L);
//        storageDto.setQuantity(1003);
//        storageDto.setPrice(105);
//        storageService.update(storageDto);
//        System.out.println(storageService.getById(3L));
//        System.out.println("And sort");
//        System.out.println(storageService.sortProductByPriceInStores(3L));
//
//        System.out.println("New order");
//        orderService.add(3L, 3L, 3L, 1);
//        System.out.println(orderService.getById(1L));
//
//        System.out.println(clientService.getById(3L));
//        System.out.println("Delete client");
//        clientService.remove(3L);
//        System.out.println(clientService.getById(3L));
//        System.out.println(productService.getById(3L));
//        System.out.println("Delete product");
//        productService.remove(3L);
//        System.out.println(productService.getById(3L));
//        System.out.println(storeService.getById(3L));
//        System.out.println("Delete store");
//        storeService.remove(3L);
//        System.out.println(storeService.getById(3L));
//    }
}

