// alert("hello boy");

// document.write("hello my sweaty!");

console.log("this is a log");

//用var声明变量
var test = 20;

//变量可以存放不同类型的值
test = "张三"

//使用let定义的变量不可重复声明
let id = 20;
// let id = "张三";//Uncaught SyntaxError: Identifier 'id' has already been declared (at main.js:14:5)

//const定义常量不可改变
const VALUE = 10;
//VALUE = 20;//Attempt to assign to const or readonly variable


//数据类型
var age = 30;
var price = 34.5;

var name = "刘邦";

var valid = true;

var obj = null;

var testUndefine;

console.log("typeof age = " + typeof age)
console.log("typeof name = " + typeof name)
console.log("typeof valid = " + typeof valid)
console.log("typeof obj = " + typeof obj)
console.log("typeof testUndefine = " + typeof testUndefine)

//运算符
var number1 = 30;
var number2 = "30";

//==和===的区别
console.log(number1 == number2);
console.log(number1 === number2);

//类型转换
var number3 = +"40";
console.log(number3 + 1);
console.log(parseInt(number3) + 1);

var flag = +false;
console.log("flag = " + flag);

//number类型转换为boolean类型，0和nan转化为false,其他数字转为true
//string类型转换为boolean类型，空字符串为false,其他字符串转为true
//null类型转换为boolean类型是false
//undefined转换为boolean类型是false
var test1 = undefined;
if (test1) {
  console.log("test is true")
} else {
  console.log("test is false")
}



console.log("============== 流程控制语句 ===============")
//流程控制语句
//if
var count = 5;
if (count == 5) {
  console.log("count = " + count);
}

//switch
var num = 4;
switch (num) {
  case 4:
    console.log("周四") ;
    break;
  case 3:
    console.log("周三");
    break;
  default:
    console.log("错误");
    break;
}

//for
var sum = 10;
for (let i = 3; i<= 20; i++) {
  sum += i;
}
console.log("sum = " + sum);

//while
var total = 0;
var i = 0;
while (i <= 30) {
  total += i;
  i++;
}
console.log("total = " + total);

//dowhile
var sum = 0;
var i = 1;
do {
  sum += i;
  i++;
}while (i <= 10);
console.log("sum = " + sum);

console.log("============== 函数 ===============")
//定义方式
function testMethod1(i, j, k) {
  console.log("method way 1");
  return 1 + j + k;
}

var testMethod2 = function (i, j) {
  console.log("method way 2");
  return i + j;
}

//函数调用
let result1 = testMethod1(1, 2, 3);
let result2 = testMethod2(1, 2, 3);
console.log("result1 = " + result1);
console.log("result2 = " + result2);

console.log("============== 常用对象 ===============")
//Array
var array1 = new Array(1, 2, 3);
var array2 = [1, 2, 3];

console.log("array1 = " + array1);
console.log("array2 = " + array2);

//元素访问
var value = array1[2];
console.log("value = " + value);

//数组可动态拓展
var array3 = [1, 2, 3];
array3[10] = 20;
console.log("array3 = " + array3);
console.log("array3[4] = " + array3[4] );

//可添加不同类型
array3[4] = "value";
console.log("array3[4] = " + array3[4] );

//属性
console.log("array3.length = " + array3.length);

//方法
array3.push(30);
console.log("after push array3 = " + array3);

array3.splice(2, 1);
console.log("after splice array3 = " + array3);


// String对象
var str = ' abc  ';
console.log( 1 + str + 1);
console.log( 1 + str.trim() + 1);

// 自定义对象
var person = {
  name : "吕布",
  age : 24,
  fight: function () {
    console.log("吕布打架");
  }
}

person.fight();

console.log("============== BOM ===============")
// window:浏览器窗口对象
// navigator: 浏览器对象
// screen: 屏幕对象
// history: 历史记录对象
// Location: 地址栏对象

//显示调用
// window.alert("Hello Tom!");

//隐式调用
// alert("Hello Jerry!");

//window属性
// window.history
// window.location
// window.navigator
// window.screen
//
// //window对象函数
// window.alert("哈哈");
// // window.confirm("come on");
// window.setInterval()
// window.setTimeout()
//
// //window.confirm
// var flag = confirm("确认删除？");
// alert(flag);



//window.setTimeout
// setTimeout(function (){
//   console.log("Time out");
// }, 3000);

//window.setInterval
// setInterval(function (){
//   console.log("interval()")
// }, 2000);

// window.history.back()   //跳转到上一个访问的页面
// window.history.forward()//跳转到下一个访问的页面

// window.location.方法();
// location.方法();

// alert("将要跳转到百度")
// location.href = "http://www.baidu.com"
// document.write("2s后跳转到首页")
// setTimeout(function () {
//   location.href = "http://www.baidu.com"
// }, 3000);


// DOM
console.log("==================== DOM ==================")
var img = document.getElementById("light")
console.log(img);

//获取所有的div元素对象
var divs = document.getElementsByTagName("div")
console.log("divs.length = " + divs.length);

for (let i = 0; i < divs.length; i++) {
    console.log("div " + i + " = " + divs[i]);
}

// 获取所有满足name="hobby"条件的元素对象
var hoppys = document.getElementsByName("hoppy");
for (let i = 0; i < hoppys.length; i++) {
    console.log("hoppys " + i + ", = " + hoppys[i]);
}

//获取所有满足class='cls'条件元素对象
var clazz = document.getElementsByClassName('cls');
for (let i = 0; i < clazz.length; i++) {
  console.log("clazz " + i + " = " + clazz[i]);
}

//需求
// // 1 点亮灯泡
// var img = document.getElementById("light");
// img.src = "../img/on.gif";
//
// //2 将所有的div标签的内容替换为 "打游戏"
// var divs = document.getElementsByTagName("div");
// for (let i = 0; i < divs.length; i++) {
//    divs[i].innerHTML = "打游戏";
// }
//
// //3 将所有的复选框改为被选中状态
// var hobbys = document.getElementsByName("hoppy");
// for (let i = 0; i < hobbys.length; i++) {
//     hobbys[i].checked = true;
// }











