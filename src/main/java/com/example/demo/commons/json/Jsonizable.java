package com.example.demo.commons.json;

import com.example.demo.utils.JsonUtils;

public interface Jsonizable {

    default String toJson() {
        return JsonUtils.dump(this);
    }
}
