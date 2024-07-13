package com.chandra.service;

import com.chandra.entities.Product;
import com.chandra.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void getProduct(){
        List<Product> records =productRepo.findAll(Sort.by("price").descending());
        records.forEach(enty1->{
            System.out.println(enty1);
        });

    }

    public void QByExample(){
        Product entity=new Product();
        entity.setPname("Mouse");
        //entity.setPid(108);
        List<Product> products=productRepo.findAll(Example.of(entity));//query by example
        products.forEach(p->{
            System.out.println(p);
        });
    }

    public void Pagination(){
        int pageSize=3;
        int pageNumber=0;

        PageRequest of=PageRequest.of(pageNumber,pageSize);// request for pagination
        Page<Product> page= productRepo.findAll(of);// divide the pages and store in page
        List<Product>  products=page.getContent();// for that pages load the product table data
        products.forEach(pages->{             // printing that page content
            System.out.println(pages);
        });


    }

    public void saveProduct(){
        Product entity1 =new Product(101,"Mouse",500.00);
        Product entity2=new Product(102,"keyboard",2500.00);
        Product entity3 =new Product(103,"touch",5030.00);
        Product entity4 =new Product(104,"keys",505650.00);
        Product entity5 =new Product(105,"hardsik",5040.00);
        Product entity6 =new Product(106,"disk",53400.00);
        Product entity7 =new Product(107,"Monitor",50000.00);
        Product entity8 =new Product(108,"display",8500.00);

      productRepo.saveAll(Arrays.asList(entity1,entity2,entity3,entity4,entity5,entity6,entity7,entity8));

    }







}

