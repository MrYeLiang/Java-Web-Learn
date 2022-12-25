<%--
  Created by IntelliJ IDEA.
  User: yl
  Date: 2022/12/25
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .el-table .warning-row {
            background: oldlace;
        }

        .el-table .success-row {
            background: #f0f9eb;
        }
    </style>
</head>
<body>
<div id="app">
    <template>
        <el-table
                :data="tableData"
                style="width: 100%"
                :row-class-name="tableRowClassName"
                tooltip-effect="dark"
                @selection-change="handleSelectionChange">
            <el-table-column
                    type="selection"
                    width="50"
                    align="center">
            </el-table-column>

            <el-table-column
                    prop="brandName"
                    label="品牌名称"
                    width="180"
                    align="center">
            </el-table-column>

            <el-table-column
                    prop="companyName"
                    label="企业名称"
                    width="180"
                    align="center">
            </el-table-column>

            <el-table-column
                    prop="order"
                    label="排序"
                    width="180"
                    align="center">
            </el-table-column>

            <el-table-column
                    prop="status"
                    label="状态"
                    width="180"
                    align="center">
            </el-table-column>

            <el-table-column
                    prop="operation"
                    label="操作"
                    width="180"
                    align="center">
                <el-row>
                    <el-button type="primary">修改</el-button>
                    <el-button type="danger">删除</el-button>
                </el-row>
            </el-table-column>
        </el-table>
    </template>
</div>

<script src="../js/vue.js"></script>
<script src="../element-ui/lib/index.js"></script>
<link rel="stylesheet" href="../element-ui/lib/theme-chalk/index.css">

<script>
    new Vue({
        el: "#app",
        methods: {
            tableRowClassName({row, rowIndex}) {
                if (rowIndex === 1) {
                    return 'warning-row';
                } else if (rowIndex === 3) {
                    return 'success-row';
                }
                return '';
            },
            handleSelectChange(val) {
                this.multipleSelection = val;
            }
        },
        data() {
            return {
                tableData: [{
                    brandName: '大众',
                    companyName: '上海大众',
                    order: '200',
                    status: '1'
                }, {
                    brandName: '大众',
                    companyName: '上海大众',
                    order: '200',
                    status: '1'
                }, {
                    brandName: '大众',
                    companyName: '上海大众',
                    order: '200',
                    status: '1'
                }, {
                    brandName: '大众',
                    companyName: '上海大众',
                    order: '200',
                    status: '1'
                }]
            }
        }
    })
</script>

</body>
</html>
