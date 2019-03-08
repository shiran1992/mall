import React, { Component } from 'react';
import { message, Icon, Button, Input } from 'antd';
import API from "../utils/API";

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            pwd: ''
        };
    }

    emitEmpty() {
        this.userNameInput.focus();
        this.setState({ userName: '' });
    }

    onChangePassword(e) {
        this.setState({ pwd: e.target.value });
    }

    render() {
        const { userName } = this.state;
        const suffix = userName ? <Icon type="close-circle" onClick={this.emitEmpty} /> : null;
        return (
            <div style={{ margin: "0 auto", overflow: "hidden" }}>
                <div id="header">
                    <div className="logo">
                        <h1>电脑配件城</h1>
                    </div>
                </div>
                <div id="content">
                    <div className="login-newbg"></div>
                    <div className="content-layout">
                        <div className="login-box-warp">
                            <div className="login-title">登录</div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 40, width: 250, height: 50, }}>
                                <Input
                                    placeholder="手机号"
                                    prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
                                    suffix={suffix}
                                    ref={node => this.userNameInput = node}
                                />
                            </div>
                            <div style={{ display: 'flex', alignItems: 'center', marginTop: 20, width: 250, height: 50, }}>
                                <Input.Password placeholder="密码" onChange={(e) => { this.onChangePassword(e); }} />
                            </div>
                            <div style={{ marginTop: 40 }}>
                                <Button type="primary" block onClick={() => { this.onClickLogin(); }}>登录</Button>
                            </div>
                            <span className="small-text" style={{ float: "right", marginTop: 10, }} onClick={() => { this.routerTo(); }}>
                                注册
                            </span>
                        </div>

                    </div>
                </div>

                <div id="footer">
                    <div className="footer-bd">
                        <p style={{ textAlign: "center" }}>
                            <span>网络文化经营许可证：浙网文[2016]0132-032号</span>
                            <b>|</b>
                            <span>增值电信业务经营许可证：浙B2-20080224-1</span>
                            <b>|</b>
                            <span>信息网络传播视听节目许可证：1109364号</span>
                        </p>
                    </div>
                </div>
            </div>
        )
    }

    //点击注册
    routerTo(v) {
        this.props.history.push({ pathname: `/register`, state: { data: v } });
    }

    //点击登录
    async onClickLogin() {
        if(!this.userNameInput.state.value){
            message.error("手机号码不可以为空哦~");
            return;
        }
        if(!this.state.pwd){
            message.error("密码不可以为空哦~");
            return;
        } 
        let data = await API("LoginServlet", {
            phone: this.userNameInput.state.value,
            password: this.state.pwd
        }, { method: "get" });
        if (data && data != "false") {
            console.log(data);
            localStorage.setItem('userinfo', JSON.stringify(data));
            this.props.history.push({ pathname: `/`, state: { } });
        } else {
            message.error("账号或者密码错误！")
        }
    }
}

export default Login;