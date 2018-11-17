using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace Clarenews.Controllers
{
    [Route("api/[controller]")]
    public class ClarenewsController : Controller
    {
        // GET api/values
        [HttpGet]
        public IEnumerable<Artikel> Get()
        {
            var client = new HttpClient();
            var inrikes = JsonConvert.DeserializeObject<IEnumerable<Artikel>>(client.GetStringAsync("http://10.110.171.159/inrikes").Result).ToList();
            var kultur = JsonConvert.DeserializeObject<IEnumerable<Artikel>>(client.GetStringAsync("http://10.110.171.79/kultur").Result).ToList();
            var sport = JsonConvert.DeserializeObject<IEnumerable<Artikel>>(client.GetStringAsync("http://10.110.171.112:8080/sport").Result).ToList();
            inrikes.AddRange(sport);
            inrikes.AddRange(kultur);
            return inrikes;
        }
    }
}

public class Artikel {
    public string Rubrik { get; set; }
    public string Brodtext { get; set; }
}
