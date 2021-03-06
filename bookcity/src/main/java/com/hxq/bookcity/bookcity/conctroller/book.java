package com.hxq.bookcity.bookcity.conctroller;

import com.hxq.bookcity.bookcity.Service.bookservice;
import com.hxq.bookcity.bookcity.pojo.BOOK;
import com.hxq.bookcity.bookcity.pojo.Page;
import com.hxq.bookcity.bookcity.utils.webutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class book {
    @Autowired
    bookservice bookservice;
    @RequestMapping("/manager/page")
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        Page<BOOK> bookPage = bookservice.page(pageNo,pagesize);
        bookPage.setUrl("manager/page");
        request.setAttribute("page",bookPage);


        request.getRequestDispatcher("/pages/manager/book_manager2.jsp").forward(request,response);


    }
    @RequestMapping("client/page")
    protected void page1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        Page<BOOK> bookPage = bookservice.page(pageNo,pagesize);
        bookPage.setUrl("/client/page");
        request.setAttribute("page",bookPage);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }
    @RequestMapping("/addbook")
    protected void addbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BOOK bean = new BOOK();
        int pageNo=webutils.parseInt(request.getParameter("pageNo"),0)+1;
        webutils.copypartobean(request.getParameterMap(), bean);
        bookservice.addbook(bean);
        response.sendRedirect(request.getContextPath()+"/manager/page?pageNo="+pageNo);



    }
    @RequestMapping("/delete")
    protected void deletebookbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        bookservice.deletebookbyid(id);
        response.sendRedirect(request.getContextPath()+"/manager/page");

    }
    @RequestMapping("/update")
    protected void updatebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BOOK book = new BOOK();
        webutils.copypartobean(request.getParameterMap(), book);
        bookservice.updatebook(book);
        System.out.println(request.getParameter("pageNo"));
        //F5??????????????????,??????????????????????????????,???????????????????????????,???????????????????????????????????????,?????????????????????????????????,
        // ???resquest???????????????????????????,??????????????????????????????
        response.sendRedirect(request.getContextPath()+"/manager/page?pageNo="+request.getParameter("pageNo"));

    }
    //???updatebook???????????????????????????????????????
    //???????????????????????????????????????????????????????????????,?????????????????????,??????updatebook??????????????????????????????????????????
    //?????????????????????,????????????,??????list????????????????????????,????????????????????????????????????
    @RequestMapping("/getbook")
    protected void getbook(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    { Integer id = Integer.valueOf(request.getParameter("id"));
        BOOK book = bookservice.querybookbyid(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit1.jsp").forward(request,response);

    }
    @RequestMapping("/pagebyprice")
    protected void pagebyprice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = webutils.parseInt(request.getParameter("pageNo"), 1);
        int pagesize = webutils.parseInt(request.getParameter("pagesize"), 4);
        int min=webutils.parseInt(request.getParameter("min"),0);
        int max=webutils.parseInt(request.getParameter("max"),10000);
        Page<BOOK> bookPage = bookservice.pagebyprice(pageNo,pagesize,min,max);
        StringBuilder s=new StringBuilder("/pagebyprice?");
        if(request.getParameter("min")!=null)
            s.append("min").append(min);
        if(request.getParameter("max")!=null)
            s.append("&max").append(max);


        bookPage.setUrl(String.valueOf(s));
        request.setAttribute("page",bookPage);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }

}
