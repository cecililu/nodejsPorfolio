const fs = require("fs");
const express = require("express");
const { dirname } = require("path");
const app= express();
app.use(express.static(__dirname+'/public'))
app.set('view engine','ejs')



const blog=JSON.parse(
    fs.readFileSync(`${__dirname}/blog.json`)
    );


app.get('/blog',(req ,res ,next)=>{
  res.status(200).render('about',{data:blog})
})

app.get('/home',(req,res,next)=>{
    res.render('home')
})

app.get('/contact',(req,res,next)=>{
    res.render('contact')
})
 const port=process.env.PORT 
app.listen(port,()=>{
    console.log("listening to requesto on port 8000")
})