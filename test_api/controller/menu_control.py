from odoo import http
from odoo.http import request


class MenuController(http.Controller):

    @http.route('/api/menus', auth='public')
    def get_menus(self, **kwargs):
        menus = request.env['my_custom_module.menu'].sudo().search([])
        return menus.read(['menu_id', 'menu_code', 'status', 'modified_at', 'modified_by'])

    @http.route('/api/menus', type='json', auth='public')
    def create_menu(self, menu_data, **kwargs):
        menu = request.env['my_custom_module.menu'].sudo().create_menu(menu_data)
        return menu.read(['menu_id', 'menu_code', 'status', 'modified_at', 'modified_by'])

    @http.route('/api/menus', type='json', auth='public')
    def update_menu(self, menu_data, **kwargs):
        menu = request.env['my_custom_module.menu'].sudo().browse(menu_data['id'])
        menu.write(menu_data)
        return menu.read(['menu_id', 'menu_code', 'status', 'modified_at', 'modified_by'])

    @http.route('/api/menus', type='json', auth='public')
    def delete_menu(self, menu_id, **kwargs):
        menu = request.env['menu_id', 'menu_code', 'status', 'modified_at', 'modified_by'].sudo().browse(menu_id)
        menu.delete_menu()
        return True
