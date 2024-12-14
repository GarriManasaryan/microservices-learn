import React, { useState } from 'react'
import axiosConf from '../axiosConf';
import './style.css';

function MyButton() {

    const [name, setName] = useState('');

    const onNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setName(event.target.value);
    };

    const onClickSave = () => {
        axiosConf.post("/api/products", {"name":name})
    };

    const onClickGetAll = () => {
        axiosConf.get('/api/products')
        .then((response) => {
            console.log(response.data)
        })
    };

    return (
        <div>
            <div style={{paddingTop: "15rem"}}></div>
            <input id="myText" type="text" onChange={(e) => onNameChange(e)}></input>
            <button onClick={() => onClickSave()}>send save from input</button>
            <div style={{paddingTop: "5rem"}}></div>
            <button onClick={() => onClickGetAll()}>get all</button>
            <div style={{paddingTop: "5rem"}}></div>
            <button className='icon'>color-test</button>
        </div>
    )
}

export default MyButton