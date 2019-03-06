import React,{Component} from 'react';
import axios from 'axios';
import {connect} from 'react-redux';
import { productDetails,addToCart} from '../actions';
import {NavLink} from 'react-router-dom';
import { Card, CardImg, CardText, CardBody,
  CardTitle, CardSubtitle, Button } from 'reactstrap';

  const mapStateToProps = (state)=>{
    return {
        rows : state.counter.lists.rows,
        total: state.counter.lists.total
    }
}
class ProductDetail extends Component{
  componentDidMount(){
    var productId = this.props.match.params.id;
    this.props.productDetails({productId});
  }

  addToCarts = (product)=>{
    this.props.addToCart(product)
}

  show(){
        var data    = this.props.rows;
        var carUrl  = '/carts';
        var homeUrl = '/';
        return (
          <Card style={{width:"1000px",margin:"0 auto",border:"2px solid #ccc",fontFamily:'Microsoft YaHei',overflow:"hidden",position:"relative",padding:"20px"}}>
        <CardImg top style={{width:'45%',float:"left"}} src={data.img} />
        <CardBody style={{width:'52%',position:"absolute",right:"0",top:"0"}}>
            <CardTitle style={{height:"90px",overflow:'hidden',lineHeight:"35px",margin:'10px 0 0 0'}}>{data.title}</CardTitle>
            <CardSubtitle style={{color:"red",lineHeight:'18px',margin:'-6px 0 18px 0'}}>单价：${data.price}</CardSubtitle>
            <CardText style={{fontSize:'14px',color:'#666',lineHeight:'28px'}}>{data.content}</CardText>
            <CardSubtitle style={{lineHeight:'22px',color:"#888",margin:'-6px 0 18px 0'}}>上架时间：{data.time}</CardSubtitle>
            <NavLink to={homeUrl}>回到首页</NavLink>
            <Button onClick={()=>this.addToCarts(data)} size="sm" style={{margin:"0 10px"}}>加入购物车</Button>
            <NavLink to={carUrl}>去付款</NavLink>
        </CardBody>
        </Card>)
    }


  render(){
    // const {lists} = this.props;
    const {rows,total} = this.props;
    return(
       <div style={{margin:"40px 0"}}>
       {this.show()}
       </div>
     )
   }
}

export default connect(mapStateToProps,{productDetails,addToCart})(ProductDetail);
