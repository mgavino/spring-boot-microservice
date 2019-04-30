package com.mgavino.springbootmicroserviceuserservice.feign;

import com.mgavino.springbootmicroserviceuserservice.feign.conversion.PostConversionBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "post-service")
@RibbonClient(name = "post-service")
@RequestMapping("/post")
public interface PostService {

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public List<PostConversionBean> search(@RequestParam("author") String author);

}
