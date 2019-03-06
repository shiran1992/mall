var Mock=require('mockjs');
var lodash = require('lodash');
var faker  = require('faker');

module.exports=function(){
    return{
        product:lodash.times(100,function(n){
            return{
                id     : n,
                title  : Mock.Random.ctitle(10,50),
                img    : faker.image.image(),
                content: Mock.Random.cparagraph(2,10),
                time   : Mock.Random.datetime('yyyy-MM-dd HH:mm:ss'),
                price  : Math.ceil(Math.random()*1000),
                stars  : Mock.mock({
                    'number|1-100': 100
                })
            };
        })
    };
};