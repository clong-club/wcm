angular.module('myDirective', [])
		.directive(
				'myPagination',
				function(myPaginationService) {
					return {
						restrict : 'A',
						replace : true,
						scope : {
							pageObject : '='
						},
						templateUrl : 'admin/templ/myPagination.html',
						link : function(scope, element, attrs) {
							scope.upPageClick = function(page) {
								myPaginationService.upPageClick(
										scope.pageObject, page);
								// console.log(scope.pageObject.currentPage);
							};
							scope.downPageClick = function(page) {
								myPaginationService.downPageClick(
										scope.pageObject, page);
								// console.log(scope.pageObject.currentPage);
							};
							scope.showFirstPage = function(page) {
								myPaginationService.showFirstPageContent(
										scope.pageObject, page);
								// console.log(scope.pageObject.currentPage);
							};
							scope.showLastPage = function(page) {
								myPaginationService.showLastPageContent(
										scope.pageObject, page);
								console.log(scope.pageObject.currentPage);
							};
							scope.showCurrentPage = function(page) {
								myPaginationService.showCurrentPageContent(
										scope.pageObject, page);
								// console.log(scope.pageObject.currentPage);
							};
						}
					};
				});