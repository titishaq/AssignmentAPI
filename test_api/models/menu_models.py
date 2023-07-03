from odoo import models, fields


class Menu(models.Model):
    _name = 'my_custom_module.menu'
    _description = 'Menu Entity'

    menu_id = fields.Char(string='Menu ID', required=True)
    menu_code = fields.Char(string='Menu Code')
    status = fields.Boolean(string='Status')
    modified_by = fields.Char(string='Modified By')
    modified_at = fields.Datetime(string='Modified At', readonly=True, auto_now=True)

    def create_menu(self, menu_data):
        return self.create(menu_data)

    def delete_menu(self):
        self.unlink()