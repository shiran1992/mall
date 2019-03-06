import axios from 'axios'

export const getListData = (data)=>{
    return {
        type   : 'GETLISTS',
        payload: data
    }
}

export const fetchList = (params={page:1})=>{
    return (dispatch)=>{
        const url = `http://localhost:3000/product?_page=${params.page}&_limit=20&_sort=id&_order=desc`
        axios({
            url   : url,
            method: 'get'
        }).then(res=>{
            var obj ={
                rows : res.data,
                total: res.headers['x-total-count']
            }
            dispatch(getListData(obj))
        })
    }
}

export const productDetails = (data)=>{

    return (dispatch)=>{
        console.log(data.productId);
        const url = `http://localhost:3000/product/${data.productId}`
        axios({
            url   : url,
            method: 'get'
        }).then(res=>{
            var obj ={
                rows : res.data,
                total: res.headers['x-total-count']
            }
            dispatch(getListData(obj))
        })
    }
}