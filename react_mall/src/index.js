// 入口文件
import React from 'react';
import ReactDOM from 'react-dom';
import maincss from './css/main.scss';
import antdcss from './css/antd.css';
import { Provider } from 'react-redux';
import store from './store';
import Footer from './components/footer';
import Navigator from "./components/Navigator";
import Home from "./page/Home";
import Login from "./page/Login";
import Register from "./page/Register";
import About from "./page/About";
import ProductDetail from "./page/ProductDetail";
import ProductList from "./page/ProductList";
import Carts from "./page/Carts";

import { HashRouter as Router, Route, Switch } from 'react-router-dom'

class Index extends React.Component {

    render() {
        return (
            <Router>
                <Switch>
                    <Route path="/login" component={Login} exact />
                    <Route path="/register" component={Register} exact />
                    <div>
                        <Navigator />
                        <Route path="/" component={Home} exact />
                        <Route path="/about" component={About} />
                        <Route path="/product/:id" component={ProductDetail} />
                        <Route path="/products" component={ProductList} />
                        <Route path="/carts" component={Carts} />
                        <Footer />
                    </div>
                </Switch>
            </Router>
        )
    }
}


ReactDOM.render(<Provider store={store}><Index /></Provider>, document.getElementById('app'));