import React,{Component} from 'react';
import {connect} from 'react-redux';
import { fetchList,addToCart } from '../actions'
import {NavLink} from 'react-router-dom';
import { Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button } from 'reactstrap';
const mapStateToProps = (state)=>{
    return {
        rows : state.counter.lists.rows,
        total: state.counter.lists.total
    }
}


class Product extends Component{

    componentDidMount(){
        this.props.fetchList();
    }
    changePages = (page)=>{
        this.props.fetchList({page})
    }

    showPages(){
        var pages = Math.ceil(this.props.total / 20);
        var jsx   = [];
        for(let i=1;i<=pages;i++){
            jsx.push(
                <li className="page-item" key={i} onClick={()=>this.changePages(i)}><a className="page-link" href="javascript:void(0)">{i}</a></li>
            )
        }
        return jsx;
    }

    addToCarts = (product)=>{
        this.props.addToCart(product)
    }

    showRows(rows){
        if(rows.length>0){
        console.log(rows)
            var jsx = [];
            rows.map((item,index)=>{
                var detaiUrl = '/product/'+item.id;
                var carUrl   = '/carts';
                jsx.push(
                    <Card style={{width:"23%",height:"400px",margin:"12px",border:"2px solid #ccc",float:'left',fontFamily:'Microsoft YaHei'}} key={index}>
                    <CardImg top style={{width:'100%'}} src={item.img} />
                    <CardBody>
                        <CardTitle style={{width:'100%',height:"48px",overflow:'hidden',margin:'-6px 0 6px 0'}}>{item.title}</CardTitle>
                        <CardSubtitle style={{width:'100%',color:"red",lineHeight:'18px',margin:'-6px 0 6px 0'}}>单价：${item.price}</CardSubtitle>
                        <CardText style={{width:'100%',height:"36px",overflow:'hidden',fontSize:'14px',color:'#666',lineHeight:'18px'}}>{item.content}</CardText>
                        <NavLink to={detaiUrl}>产品详情</NavLink>
                        <Button onClick={()=>this.addToCarts(item)} size="sm" style={{margin:"0 10px"}}>加入购物车</Button>
                        <NavLink to={carUrl}>去付款</NavLink>
                    </CardBody>
                    </Card>
                )
            })
        return jsx;
    }else{
        return null;
      }
    }

  render(){
      const {rows,total} = this.props;
    return (
      <div>
        Product-----
        <hr/>
        <nav aria-label="Page navigation example" style={{width:"1170px",margin:"0 auto"}}>
              <ul className="pagination">
                {this.showPages()}
              </ul>
        </nav>
        <div style={{width:"1200px",margin:"0 auto",overflow:"hidden"}}>
           {this.showRows(rows)}
        </div>
        <nav aria-label="Page navigation example" style={{width:"1170px",margin:"0 auto"}}>
              <ul className="pagination">
                {this.showPages()}
              </ul>
        </nav>
      </div>
    )
  }

}
export default connect(mapStateToProps,{fetchList,addToCart})(Product);