package com.learnjdbc.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.service.IProductService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(urlPatterns = {"/api-upload"})
public class UploadServlet extends HttpServlet{
    @Inject
    IProductService productService;
    // Đường dẫn đến thư mục lưu trữ ảnh sản phẩm
    private static final String UPLOAD_DIR = "/template/web/img/product";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ProductModel productModel=new ProductModel();
        DiskFileItemFactory diskFileItemFactory= new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        ServletContext servletContext=this.getServletConfig().getServletContext();
        try {
            List<FileItem> items=servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if(item.getFieldName().equals("name")){
                    productModel.setName(item.getString());
                }else if(item.getFieldName().equals("importPrice")){
                    productModel.setImportPrice(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("exportPrice")){
                    productModel.setExportPrice(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("discountPrice")){
                    productModel.setDiscountPrice(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("descriptions")){
                    productModel.setDescriptions(item.getString());
                }else if(item.getFieldName().equals("weight")){
                    productModel.setWeight(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("categoryId")){
                    productModel.setCategoryId(Integer.parseInt(item.getString()));
                }else if(item.getFieldName().equals("imageUrl")) {
                    if (item.getSize() > 0) {
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String extension = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + extension;
                        String storePath = servletContext.getRealPath(UPLOAD_DIR);
                        File file = new File(storePath + "/" + fileName);
                        item.write(file);
                        productModel.setImageUrl(fileName);
                    } else {
                        productModel.setImageUrl("image1");
                    }
                }
            }
            boolean isSuccess = productService.save(productModel);
            if (isSuccess) {
                ProductModel newModel = productService.getOne(productModel.getId());
                objectMapper.writeValue(response.getOutputStream(), newModel);
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to save product");
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ProductModel productModel=new ProductModel();
        DiskFileItemFactory diskFileItemFactory= new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        ServletContext servletContext=this.getServletConfig().getServletContext();
        try {
            List<FileItem> items=servletFileUpload.parseRequest(request);
            FileItem fi=null;
            for (FileItem item : items) {
                if(item.getFieldName().equals("id")){
                    productModel.setId(Long.parseLong(item.getString()));
                }else if(item.getFieldName().equals("name")){
                    productModel.setName(item.getString());
                }else if(item.getFieldName().equals("importPrice")){
                    productModel.setImportPrice(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("exportPrice")){
                    productModel.setExportPrice(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("discountPrice")){
                    productModel.setDiscountPrice(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("descriptions")){
                    productModel.setDescriptions(item.getString());
                }else if(item.getFieldName().equals("weight")){
                    productModel.setWeight(Double.parseDouble(item.getString()));
                }else if(item.getFieldName().equals("categoryId")){
                    productModel.setCategoryId(Integer.parseInt(item.getString()));
                }else if(item.getFieldName().equals("imageUrl")) {
                    fi=item;
                }
            }
            ProductModel pm=productService.getOne(productModel.getId());
            if (fi.getSize() > 0) {
                String originalFileName = fi.getName();
                int index = originalFileName.lastIndexOf(".");
                String extension = originalFileName.substring(index + 1);
                String fileName = System.currentTimeMillis() + "." + extension;
                String storePath = servletContext.getRealPath(UPLOAD_DIR);

                File oldFile = new File(storePath + "/" + pm.getImageUrl());
                if (oldFile.exists()) {
                    oldFile.delete();
                }

                File file = new File(storePath + "/" + fileName);
                fi.write(file);
                productModel.setImageUrl(fileName);
            }else{
                if (pm.getImageUrl() == null || pm.getImageUrl().isEmpty()) {
                    productModel.setImageUrl("image1");
                } else {
                    productModel.setImageUrl(pm.getImageUrl());
                }
            }
            boolean isSuccess = productService.update(productModel);
            if (isSuccess) {
                ProductModel newModel = productService.getOne(productModel.getId());
                objectMapper.writeValue(response.getOutputStream(), newModel);
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to save product");
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
