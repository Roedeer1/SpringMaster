package com.roedeer.simplejdbc;

import lombok.Builder;
import lombok.Data;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 2/28/2019 10:01 AM
 **/
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
