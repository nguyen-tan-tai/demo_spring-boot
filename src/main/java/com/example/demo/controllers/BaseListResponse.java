package com.example.demo.controllers;

import com.example.demo.commons.json.Jsonizable;
import java.util.ArrayList;

public class BaseListResponse<T> extends ArrayList<T> implements Jsonizable {

    private static final long serialVersionUID = 3608915066710673630L;
}
