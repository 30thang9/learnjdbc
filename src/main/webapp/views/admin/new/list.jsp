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
                <h4>List Products</h4>
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
              <form class="row g-3 mt-3 mb-3" id="searchForm">
                <div class="col-md-4">
                  <input type="text" class="form-control" id="inputSearch" name="search" placeholder="Search...">
                </div>
                <div class="col-md-3 pt-1">
                  <button type="submit" class="btn btn-primary">Search</button>
                </div>
              </form>
              <div class="table-responsive">
                <table id="tableProduct" class="table table-striped">
                  <thead>
                    <tr>
                      <th></th>
                      <th>#</th>
                      <th>Name</th>
                      <th>Weight</th>
                      <th>ImportPrice</th>
                      <th>ExportPrice</th>
                      <th>Category</th>
                      <th>Repair</th>
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
                          ${o.getName()}
                        </td>
                        <td>
                          ${o.getWeight()}
                        </td>
                        <td>
                          ${o.getImportPrice()}
                        </td>
                        <td>
                          ${o.getExportPrice()}
                        </td>
                        <td>
                          <c:forEach var="c" items="${category.getListResult()}">
                            <c:if test="${o.getCategoryId()==c.getId()}">
                              ${c.getName()}
                            </c:if>
                          </c:forEach>
                        </td>
                        <td>
                          <button data-toggle="modal" data-target="#modalUpdate_${o.getId()}" type="button"
                            class="btn btn-outline-danger btn-xs">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                              class="bi bi-pencil-square" viewBox="0 0 16 16">
                              <path
                                d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                              <path fill-rule="evenodd"
                                d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                            </svg>
                          </button>
                          <div class="modal fade" id="modalUpdate_${o.getId()}" tabindex="-1" role="dialog"
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

  <script>
    const form = document.getElementById('searchForm'); // Lấy thẻ form
    const input = form.querySelector('input[name="search"]'); // Lấy thẻ input với attribute name là "search"

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Ngăn chặn submit form

        const searchParam = input.value; // Lấy giá trị của input
        const searchIndex = window.location.href.indexOf('&search='); // Kiểm tra xem tham số "search" đã tồn tại chưa

        let url = ''; // Khởi tạo biến URL mới

        if (searchIndex > -1) {
            // Nếu tham số "search" đã tồn tại, thay thế giá trị của nó bằng searchParam
            url = window.location.href.replace(/&search=[^&]*/, '&search=' + searchParam);
        } else {
            // Nếu tham số "search" chưa tồn tại, thêm nó vào URL mới
            url = window.location.href + '&search=' + searchParam;
        }
        url = url.replace(/(\?|&)page=[^&]*(&?)/, '$1page=1$2');
        window.location.href = url; // Chuyển đến URL mới
    });
  </script>

  <script type="text/javascript">
    var totalPages = ${ product.totalPage };
    if(totalPages==0){
        totalPages=1;
    }
    if (totalPages == 1) {
      document.getElementById("pagination").style.display = "none";
    }
    var currentPage = ${ product.page };
    var limit = 5;
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
            if (window.location.href.indexOf('&search=') !== -1) {
              const urlParams = new URLSearchParams(window.location.search);
              const searchParam = urlParams.get('search');
              $('#formSubmit').append($('<input>').attr({
                type: 'hidden',
                name: 'search',
                value: searchParam
              }));
            }
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

        $.ajax({
            type: "DELETE",
            url: "<c:url value='/api-admin-new'/>",
            contentType: "application/json",
            data: JSON.stringify({ "ids": ids }),
            success: function(response) {
                console.log('Items deleted successfully');
                //var urlParams = new URLSearchParams(window.location.search);
                //var page = urlParams.get('page');
                //let a=parseInt(page);
                // var totalPages = ${(product.totalPage*8-ids.length)/8};
                //var totalPages = ${product.totalPage};
                //console.log(totalPages);
                //let b=parseInt(totalPages);
                //if(a>b){
                    //window.location.href="<c:url value='admin-new?page=${product.totalPage}&pageSize=5&sortName=id&sortBy=desc'/>";
                //}
                //else{
                    //window.location.href="<c:url value='admin-new?page=${product.getPage()}&pageSize=5&sortName=id&sortBy=desc'/>";
                //}
                window.location.href="<c:url value='admin-new?page=1&pageSize=5&sortName=id&sortBy=desc'/>";
            },
            error: function(xhr, status, error) {
                console.error('There was a problem deleting the items:', error);
            }
        });
    }

    var deleteButton = document.getElementById("deleteButton");
    deleteButton.onclick = function() {
        deleteCheckedItems();
    };
</script>



</body>

</html>