from odoo import http
from odoo.http import request


class MenuI18NController(http.Controller):

    @http.route('/api/menu_i18n', auth='public')
    def get_menu_i18n(self, **kwargs):
        menu_i18n = request.env['my_custom_module.menu_i18n'].sudo().search([])
        return menu_i18n.read(['menu_id', 'lang_code', 'menu_name', 'menu_desc','modified_at', 'modified_by'])

    @http.route('/api/menu_i18n', type='json', auth='public')
    def create_menu_i18n(self, menu_i18n_data, **kwargs):
        menu_i18n = request.env['my_custom_module.menu_i18n'].sudo().create_menu_i18n(menu_i18n_data)
        return menu_i18n.read(['menu_id', 'lang_code', 'menu_name', 'menu_desc','modified_at', 'modified_by'])

    @http.route('/api/menu_i18n', type='json', auth='public')
    def update_menu_i18n(self, menu_i18n_data, **kwargs):
        menu_i18n = request.env['my_custom_module.menu_i18n'].sudo().browse(menu_i18n_data['id'])
        menu_i18n.write(menu_i18n_data)
        return menu_i18n.read(['menu_id', 'lang_code', 'menu_name', 'menu_desc','modified_at', 'modified_by'])

    @http.route('/api/menu_i18n', type='json', auth='public')
    def delete_menu_i18n(self, menu_id, lang_code, **kwargs):
        menu_i18n = request.env['my_custom_module.menu_i18n'].sudo().browse([menu_id, lang_code])
        menu_i18n.delete_menu_i18n()
        return True