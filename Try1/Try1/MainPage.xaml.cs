using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.PlatformConfiguration.AndroidSpecific;

namespace Try1
{
    // Learn more about making custom code visible in the Xamarin.Forms previewer
    // by visiting https://aka.ms/xamarinforms-previewer
    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
            //image.Source = new UriImageSource
            //{
            //    Uri = new Uri("https://avatars.mds.yandex.net/get-pdb/2129646/a5fa83ae-8bb0-4ace-9d5b-1e5517125447/s1200"),

            //    CacheValidity = new TimeSpan(0, 1, 0),

            //    CachingEnabled = true
            //};
            //image.Aspect = Aspect.AspectFill;
            //Oleg.ImageSource = image.Source;
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            DisplayAlert("Результат", (int.Parse(Entry1.Text) + int.Parse(Entry2.Text)).ToString(), "Ok");
        }
    }
}
