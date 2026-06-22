// Last updated: 23/06/2026, 00:01:44
/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
   
       return new Promise((resolve) => {
        setTimeout(resolve, millis)
    })
}


/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */