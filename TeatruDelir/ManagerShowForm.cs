// Created by Călin Gabriel
// at 3:59 PM on 20/03/2016.
//  

using System.Windows.Forms;

namespace TeatruDelir
{
    public class ManagerShowForm : HeadUserLabelForm
    {
        private Button addShowButton;

        private readonly UserController _userController;

        public ManagerShowForm()
        {
            
        }

        public ManagerShowForm(UserController userController) : base(userController)
        {
            var managerUserController = (ManagerUserController) userController;
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            this.addShowButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // addShowButton
            // 
            this.addShowButton.Location = new System.Drawing.Point(96, 110);
            this.addShowButton.Name = "addShowButton";
            this.addShowButton.Size = new System.Drawing.Size(119, 23);
            this.addShowButton.TabIndex = 0;
            this.addShowButton.Text = "Add today\'s show";
            this.addShowButton.UseVisualStyleBackColor = true;
            // 
            // ManagerShowForm
            // 
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.addShowButton);
            this.Name = "ManagerShowForm";
            this.Text = "Teatru delir";
            this.Load += new System.EventHandler(this.ShowForm_Load);
            this.ResumeLayout(false);

        }

        private void ShowForm_Load(object sender, System.EventArgs e)
        {
        }
    }
}