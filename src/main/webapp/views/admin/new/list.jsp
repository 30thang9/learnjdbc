<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <li class="d-inline-block">Product</li>
          </ul>
        </div>
      </div>
    </div>
    <!-- row -->

    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12">
          <div class="card">
            <div class="card-body">
              <div class="card-title d-flex justify-content-between align-items-center">
                <h4>Table Product</h4>
                <div class="d-flex justify-content-center align-items-center">
                  <div class="mr-2">
                    <button data-toggle="modal" data-target="#modalAdd" type="button"
                      class="btn btn-outline-danger">
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
                        <path
                          d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
                      </svg>
                    </button>
                    <div class="modal fade" id="modalAdd" tabindex="-1" role="dialog"
                      aria-labelledby="myModalLabel">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">Confirmation</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                          </div>
                          <div class="modal-body">
                            Do you want to add?
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal"
                              id="modalAdd">Yes</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div>
                    <button data-toggle="modal" data-target="#modalDelete" type="button"
                      class="btn btn-outline-danger">
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-trash3" viewBox="0 0 16 16">
                        <path
                          d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z" />
                      </svg>
                    </button>
                    <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog"
                      aria-labelledby="myModalLabel">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">Confirmation</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                          </div>
                          <div class="modal-body">
                            Do you want to delete?
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            <button type="button" class="btn btn-primary"
                              data-dismiss="modal" id="deleteButton">Yes</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="table-responsive">
                <table id="tableProduct" class="table table-striped">
                  <thead>
                    <tr>
                      <th></th>
                      <th>#</th>
                      <th>Name</th>
                      <th>Weight</th>
                      <th>Price</th>
                      <th>Quantity</th>
                      <th>CategoryId</th>
                      <th>SupplierId</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="o" items="${product.getListResult()}">
                      <tr>
                        <td>
                          <div style="margin:0"
                            class="form-check d-flex justify-content-between align-items-center">
                            <input style="cursor: pointer;" name="product_item" class="productCheckBox"
                              type="checkbox" value="${o.getId()}" id="product_${o.getId()}">
                            </label>
                          </div>
                        </td>
                        <td>
                          ${o.getId()}
                        </td>
                        <td>
                          ${o.getProductName()}
                        </td>
                        <td>
                          ${o.getWeight()}
                        </td>
                        <td>
                          ${o.getPrice()}
                        </td>
                        <td>
                          ${o.getQuantityInstock()}
                        </td>
                        <td>
                          <c:forEach var="c" items="${category.getListResult()}">
                            <c:if test="${o.getCategoryId()==c.getId()}">
                              ${c.getCategoryName()}
                            </c:if>
                          </c:forEach>
                        </td>
                        <td>
                          <c:forEach var="c" items="${supplier.getListResult()}">
                            <c:if test="${o.getSupplierId()==c.getId()}">
                              ${c.getSupplierName()}
                            </c:if>
                          </c:forEach>
                        </td>
                        <td>
                          <button data-toggle="modal" data-target="#modalUpdate" type="button"
                            class="btn btn-outline-danger btn-xs">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                              class="bi bi-pencil-square" viewBox="0 0 16 16">
                              <path
                                d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                              <path fill-rule="evenodd"
                                d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                            </svg>
                          </button>
                          <div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog"
                            aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h4 class="modal-title" id="myModalLabel">Confirmation</h4>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                  Do you want to update?
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                                  <a href="<c:url value='/admin-edit?type=edit&id=${o.getId()}'/>"
                                    class="btn btn-primary">Yes</a>
                                </div>
                              </div>
                            </div>
                          </div>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <form id="formSubmit" action="<c:url value='/admin-new'/>" method="get">
                  <ul class="pagination mt-5" id="pagination"></ul>
                  <input type="hidden" value="" id="page" name="page" />
                  <input type="hidden" value="" id="pageSize" name="pageSize" />
                  <input type="hidden" value="" id="sortName" name="sortName" />
                  <input type="hidden" value="" id="sortBy" name="sortBy" />
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
  <script type="text/javascript">
    $(document).on("click", "#modalAdd .btn-primary", function () {
      window.location.href = "<c:url value='/admin-edit'/>";
    });
  </script>

  <script type="text/javascript">
    var totalPages = ${ product.totalPage };
    if (totalPages == 1) {
      document.getElementById("pagination").style.display = "none";
    }
    var currentPage = ${ product.page };
    var limit = 8;
    $(function () {
      window.pagObj = $('#pagination').twbsPagination({
        totalPages: totalPages,
        visiblePages: 3,
        startPage: currentPage,
        onPageClick: function (event, page) {
          if (currentPage != page) {
            $('#page').val(page);
            $('#pageSize').val(limit);
            $('#sortName').val('id');
            $('#sortBy').val('desc');
            $('#formSubmit').submit();
          }
        }
      }).on('page', function (event, page) {
        console.info(page + ' (from event listening)');
      });
    });
  </script>


  <script type="text/javascript">
    function deleteCheckedItems() {
      const ids = Array.from(document.getElementsByClassName("productCheckBox"))
        .filter(ch => ch.checked)
        .map(ch => parseInt(ch.value));

      fetch("<c:url value='/api-admin-new'/>", {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ "ids": ids })
      })
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          console.log('Items deleted successfully');
          window.location.href="<c:url value='admin-new?page=1&pageSize=8&sortName=id&sortBy=desc&deleteId='/>"+ids;

        })
        .catch(error => {
          console.error('There was a problem deleting the items:', error);
        });
      //const totalPage=${product.totalPage};
      //window.location.href="<c:url value='admin-new?page=1&pageSize=8&sortName=id&sortBy=desc&deleteId='/>"+ids;
    }
    for(var i = 0; i <${product.getListResult().size()};i++){
        console.log(${product.getListResult().get(i).getId()});
    }
    var deleteButton = document.getElementById("deleteButton");
    deleteButton.onclick = function() {
      deleteCheckedItems();
    };

  </script>


</body>

</html>