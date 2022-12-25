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
    <%--Dialog Form--%>
    <el-button type="text" @click="dialogVisible = true">品牌添加</el-button>

    <el-dialog title="编辑品牌" :visible.sync="dialogVisible" width="30%">
        <el-form ref="form" :model="brand" label-width="80px">
            <el-form-item label="品牌名称">
                <el-input v-model="brand.brandName"></el-input>
            </el-form-item>

            <el-form-item label="企业名称">
                <el-input v-model="brand.companyName"></el-input>
            </el-form-item>

            <el-form-item label="排序">
                <el-input v-model="brand.order"></el-input>
            </el-form-item>

            <el-form-item label="产品描述">
                <el-input type="textarea" v-model="brand.description"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="addBrand">提 交</el-button>
                <el-button @click="dialogVisible = false">取 消</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>

<%-- 搜索表单 --%>
    <el-form :inline="true" :model="brand" class="demo-form-inline">
        <el-form-item label="状态">
            <el-select v-model="brand.status" placeholder="状态">
                <el-option label="启用" value="1"></el-option>
                <el-option label="禁用" value="0"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item label="企业名称">
            <el-input v-model="brand.companyName" placeholder="品牌名称"></el-input>
        </el-form-item>

        <el-form-item label="品牌名称">
            <el-input v-model="brand.brandName" placeholder="品牌名称"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
    </el-form>

    <%-- 表格 --%>
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

            //复选框选中后回调方法
            handleSelectionChange(val) {
                this.multipleSelection = val;
                console.log(this.multipleSelection)
            },

            onSubmit() {
                console.log(this.brand);
            },
            addBrand() {
                console.log(this.brand)
            }
        },
        data() {
            return {
                dialogVisible: false,
                //搜索品牌
                brand: {
                    status: '',
                    brandName: '',
                    companyName: '',
                    id: '',
                    ordered: '',
                    description: ""
                },
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
