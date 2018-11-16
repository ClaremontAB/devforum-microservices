const express = require('express')
const fs = require('fs')
const bodyParser = require('body-parser')
const app = express()
const port = 80

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

app.get('/kultur', (req, res) => {
    let currentNews = JSON.parse(fs.readFileSync('./data/kultur.json', 'utf8')).artiklar
    console.log(req)
    res.send(currentNews)
})

app.post('/kultur', (req, res) => {
    let currentNews = JSON.parse(fs.readFileSync('./data/kultur.json', 'utf8'))
    const newNews = {
        rubrik: req.body.rubrik,
        brodtext: req.body.brodtext
    }
    currentNews.artiklar.push(newNews)
    fs.writeFileSync('./data/kultur.json', JSON.stringify(currentNews))
    
    res.send()
})

app.put('/kultur', (req, res) => {
    const updatingHeader = req.body.rubrik
    
    if (updatingHeader) {
        let articles = JSON.parse(fs.readFileSync('./data/kultur.json', 'utf8')).artiklar
        let idx = articles.findIndex((a) => a.rubrik === updatingHeader)
        if (idx >= 0) {
            // update the news
            const article = {
                rubrik: req.body.rubrik,
                brodtext: req.body.brodtext
            }
            // sätt tillbaka
            articles[idx] = article
            fs.writeFileSync('./data/kultur.json', JSON.stringify({ artiklar: articles }))
            res.send('OK')
        }
        res.status(404).send('Article not found.')
    }
    res.status(404).send('Rubrik must be set.')
})

app.delete('/kultur', (req, res) => {
    const updatingHeader = req.body.rubrik
    
    if (updatingHeader) {
        let articles = JSON.parse(fs.readFileSync('./data/kultur.json', 'utf8')).artiklar
        let idx = articles.findIndex((a) => a.rubrik === updatingHeader)
        if (idx >= 0) {
            articles.splice(idx, 1) 
            fs.writeFileSync('./data/kultur.json', JSON.stringify({ artiklar: articles }))
            res.send('OK')
        }
        res.status(404).send('Article not found.')
    }
    res.status(404).send('Rubrik must be set.')
})

app.listen(port, () => console.log(`Example app listening on port ${port}!`))