const fs =require("fs");
const express = require("express");
const app= express();
app.use(express.static(__dirname+'/public'))
app.use(express.json())
app.set('view engine','ejs')

//geting json from another file
const blog=JSON.parse(
    fs.readFileSync(`${__dirname}/blog.json`)
    );

//handler function
//api
const getblog=(req,res)=>{
    res.status(200).json(blog)
}
//get blog page
const blogpage=(req ,res )=>{
    res.status(200).render('about',{ data: blog })
}
//get home page
const homepage=(req,res)=>{
    res.status(200).render('home')
}
//contact page
const contactpage=(req,res)=>{
    res.render('contact')
}



//routes
app
    .route('/v1/blogs')
    .get(getblog)

app
    .route('/blog').get(blogpage)

app
    .route('/home').get(homepage)

app
    .route('/contact')
    .get(contactpage)

//server
const port=process.env.PORT ||8000
app.listen(port,()=>{
    console.log("listening to requesto on port 8000")
})