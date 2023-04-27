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
                           <form id="form-submit" class="row g-3" enctype="multipart/form-data">
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault01" class="form-label">Product Name</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getName()}" type="text" class="form-control" id="validationDefault01" name="name" required>
                                       </div>
                                   </div>
                               </div>

                               <div class="col-md-12">
                                  <div class="row g-3">
                                      <div class="col-md-4">
                                          <label for="validationDefault02" class="form-label">ImportPrice</label>
                                      </div>
                                      <div class="col-md-8">
                                          <input value="${product.getImportPrice()}" type="number" class="form-control" id="validationDefault02" name="importPrice" required>
                                      </div>
                                  </div>
                               </div>
                               <div class="col-md-12">
                                 <div class="row g-3">
                                     <div class="col-md-4">
                                         <label for="validationDefault03" class="form-label">ExportPrice</label>
                                     </div>
                                     <div class="col-md-8">
                                         <input value="${product.getExportPrice()}" type="number" class="form-control" id="validationDefault03" name="exportPrice" required>
                                     </div>
                                 </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault04" class="form-label">Discount Price</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getDiscountPrice()}" type="number" class="form-control" id="validationDefault04" name="discountPrice" required >
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault05" class="form-label">Descriptions</label>
                                       </div>
                                       <div class="col-md-8">
                                           <textarea class="form-control" id="validationDefault05" name="descriptions" required>${product.getDescriptions()}</textarea>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault06" class="form-label">Weight</label>
                                       </div>
                                       <div class="col-md-8">
                                           <input value="${product.getWeight()}" type="number" step="0.1" class="form-control" id="validationDefault06" name="weight" required>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                   <div class="row g-3">
                                       <div class="col-md-4">
                                           <label for="validationDefault07" class="form-label">Category</label>
                                       </div>
                                       <div class="col-md-8">
                                           <select class="form-select" id="validationDefault07" name="categoryId" required>
                                              <option selected disabled value="">Choose...</option>
                                              <c:forEach var="o" items="${category.getListResult()}">
                                                  <option value="${o.getId()}" ${type!=null && product.getCategoryId()==o.getId() ? 'selected' : ''}>
                                                      ${o.getName()}
                                                  </option>
                                              </c:forEach>
                                           </select>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-md-12">
                                 <div class="row g-3 form-group">
                                   <div class="col-md-4">
                                     <label for="validationDefault09" class="form-label">Product Image:</label>
                                   </div>
                                   <div class="col-md-8">
                                     <div class="custom-file">
                                       <input type="file" class="custom-file-input" id="validationDefault09" name="imageUrl" ${type!=null?'':'required'}>
                                       <label class="custom-file-label" for="validationDefault09">Choose file</label>
                                     </div>
                                   </div>
                                 </div>
                               </div>
                               <div class="col-md-12">
                                 <img style="width:100px;" id="previewImage" src="<c:url value='/template/web/img/product/'/>${product.getImageUrl()}" alt="Product Image" style="max-width: 100%; height: auto;">
                               </div>

                               <div class="col-md-12 d-flex justify-content-center align-items-center">
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
    var formData = new FormData(this);
    var type="${type}";
    if(type!=null){
        formData.append("id", "${product.getId()}");
    }
    console.log(formData);
    $.ajax({
      url: "<c:url value='/api-upload'/>",
      type: ${type==null?'"POST"':'"PUT"'},
      data: formData,
      contentType: false,
      processData: false,
      dataType: "json",
      success: function(response) {
        var msg =${type==null?'"Thêm thành công"':'"Sửa thành công"'};
        alert(msg);
        location.reload(true);
      },
      error: function(xhr, textStatus, errorThrown) {
        console.log(xhr.responseText);
      }
    });
  });
});
</script>


<script>
  function readURL(input) {
    if (input.files && input.files[0]) {
      var reader = new FileReader();

      reader.onload = function (e) {
        $('#previewImage').attr('src', e.target.result);
      }

      reader.readAsDataURL(input.files[0]); // convert to base64 string
    }
  }

  $("#validationDefault09").change(function () {
    readURL(this);
  });
</script>


</body>
</html>