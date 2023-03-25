<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>

</head>
<body>

<!--**********************************
    Content body start
***********************************-->
<div class="content-body">

    <div class="container-fluid">
        <div class="row">
            <div class="col">
                  <ul class="list-inline d-flex align-items-center mb-2 mt-2 ml-4">
                    <li class="d-inline-block ml-3">Home</li>
                    <li class="d-inline-block ml-3 mr-3">/</li>
                    <li class="d-inline-block">Product details</li>
                  </ul>
            </div>
        </div>
    </div>
    <!-- row -->

    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="form-validation p-4">

                            <!---->
                           <form id="form-submit" class="row g-3">
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault01" class="form-label">Product Name</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getProductName()}" type="text" class="form-control" id="validationDefault01" name="productName" required>
                                       </div>
                                   </div>
                               </div>

                               <div class="col-md-12">
                                  <div class="row g-3">
                                      <div class="col-md-4">
                                          <label for="validationDefault02" class="form-label">Price</label>
                                      </div>
                                      <div class="col-md-8">
                                          <input value="${product.getPrice()}" type="text" class="form-control" id="validationDefault02" pattern="\d*" name="price" required>
                                      </div>
                                  </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault03" class="form-label">Discount Price</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getDiscountPrice()}" type="text" class="form-control" id="validationDefault03" pattern="\d*" name="discountPrice" required >
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault04" class="form-label">Discount Quantity</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getDiscountQuantity()}" type="text" class="form-control" id="validationDefault04" pattern="\d*" name="discountQuantity" required>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault05" class="form-label">Discount Status</label>
                                       </div>
                                       <div class="col-md-8">
                                            <select class="form-select" id="validationDefault06" name="discountStatus" required>
                                                <option selected disabled value="">Choose...</option>
                                                <option value="true" ${type!=null && product.getDiscountStatus() ? 'selected' : ''}>Active</option>
                                                <option value="false" ${type!=null && !product.getDiscountStatus() ? 'selected' : ''}>Inactive</option>
                                            </select>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault06" class="form-label">Hot Status</label>
                                       </div>
                                       <div class="col-md-8">
                                           <select class="form-select" id="validationDefault06" name="hotStatus" required>
                                              <option selected disabled value="">Choose...</option>
                                              <option value="true" ${type!=null && product.getHotStatus() ? 'selected' : ''}>Active</option>
                                              <option value="false" ${type!=null && !product.getHotStatus() ? 'selected' : ''}>Inactive</option>
                                           </select>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault07" class="form-label">Selling Status</label>
                                       </div>
                                       <div class="col-md-8">
                                           <select class="form-select" id="validationDefault07" name="sellingStatus" required>
                                              <option value="" selected disabled>Choose...</option>
                                              <option value="true" ${type!=null && product.getSellingStatus() ? 'selected' : ''}>Active</option>
                                              <option value="false" ${type!=null && !product.getSellingStatus() ? 'selected' : ''}>Inactive</option>
                                           </select>
                                       </div>
                                   </div>
                               </div>

                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault08" class="form-label">Descriptions</label>
                                       </div>
                                       <div class="col-md-8">
                                           <textarea value="${product.getDescriptions()}" class="form-control" id="validationDefault08" name="descriptions" required></textarea>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault09" class="form-label">Weight</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getWeight()}" type="text" class="form-control" id="validationDefault09" pattern="\d*" name="weight" required>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault10" class="form-label">Category</label>
                                       </div>
                                       <div class="col-md-8">
                                           <select class="form-select" id="validationDefault10" name="categoryId" required>
                                              <option selected disabled value="">Choose...</option>
                                              <c:forEach var="o" items="${category.getListResult()}">
                                                  <option value="${o.getId()}" ${type!=null && product.getCategoryId()==o.getId() ? 'selected' : ''}>
                                                      ${o.getCategoryName()}
                                                  </option>
                                              </c:forEach>
                                           </select>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault11" class="form-label">Supplier</label>
                                       </div>
                                       <div class="col-md-8">
                                            <select class="form-select" id="validationDefault11" name="supplierId" required>
                                               <option selected disabled value="">Choose...</option>
                                               <c:forEach var="o" items="${supplier.getListResult()}">
                                                   <option value="${o.getId()}" ${type!=null && product.getSupplierId()==o.getId() ? 'selected' : ''}>
                                                       ${o.getSupplierName()}
                                                   </option>
                                               </c:forEach>
                                            </select>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault12" class="form-label">Quantity in Stock</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getQuantityInstock()}" type="text" class="form-control" id="validationDefault12" pattern="\d*" name="quantityInstock" required>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault13" class="form-label">Product Status</label>
                                       </div>
                                       <div class="col-md-8">
                                           <select class="form-select" id="validationDefault13" name="productStatus" required>
                                              <option value="" selected disabled>Choose...</option>
                                              <option value="true" ${type!=null && product.getProductStatus() ? 'selected' : ''}>Active</option>
                                              <option value="false" ${type!=null && !product.getProductStatus() ? 'selected' : ''}>Inactive</option>
                                           </select>
                                       </div>
                                   </div>
                               </div>

                               <div class="col-md-12">
                                 <div class="row g-3">
                                   <div class="col-md-4">
                                     <span>Image</span>
                                   </div>
                                   <div class="col-md-8 custom-file">
                                     <input type="file" class="custom-file-input mr-3" id="validationDefault14" name="imageUrl" required>
                                     <label for="validationDefault14" class="custom-file-label ml-3 mr-3">Choose file</label>
                                     <div class="invalid-feedback">
                                       Please choose a file.
                                     </div>
                                   </div>
                                 </div>
                               </div>
                               <div class="col-md-12">
                                   <button class="btn btn-primary" type="submit">Submit form</button>
                               </div>
                           </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- #/ container -->
</div>
<!--**********************************
    Content body end
***********************************-->

<script src="<c:url value='/template/admin/plugins/validation/jquery.validate.min.js'/>"></script>
<script src="<c:url value='/template/admin/plugins/validation/jquery.validate-init.js'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
      $("#form-submit").submit(function(event) {
        event.preventDefault();
        var formData = $(this).serializeArray();
        var jsonData = {};
        const type="${type}";
        if(type!=null){
            jsonData["id"]="${product.getId()}";
        }
        $.each(formData, function(index, field) {
          jsonData[field.name] = field.value;
        });
        console.log(jsonData);
        $.ajax({
          url: "<c:url value='/api-admin-new'/>",
          type: ${type==null?'"POST"':'"PUT"'},
          data: JSON.stringify(jsonData),
          contentType: "application/json",
          dataType: "json",
          success: function(response) {
            console.log(response);
          },
          error: function(xhr, textStatus, errorThrown) {
            console.log(xhr.responseText);
          }
        });
        location.reload(true);
      });
    });

</script>

</body>
</html>