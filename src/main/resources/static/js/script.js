let currentTheme=getTheme();
changeTheme();
// document.querySelector("#theme_change_btn span").textContent = currentTheme === "light" ? "Dark" : "Light";
function getTheme(){
    let theme=localStorage.getItem("theme");
    return theme? theme:"Light";
}

function setTheme(theme){
    localStorage.setItem("theme", theme);
}

function changeTheme(){
    document.querySelector('html').classList.add(currentTheme);
    setTheme(currentTheme);
}

document.querySelector("#theme_change_btn").addEventListener("click", function() {
    let theme=currentTheme;
   currentTheme= currentTheme==="light"?"dark":"light";
   document.querySelector('html').classList.remove(theme);
   document.querySelector('html').classList.add(currentTheme);
   setTheme(currentTheme);
   this.querySelector('span').textContent=currentTheme==="light"?"Dark":"Light";

});
