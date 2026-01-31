package org.example.ss8_songs_validate.controller;

import jakarta.validation.Valid;
import org.example.ss8_songs_validate.entity.Song;
import org.example.ss8_songs_validate.service.ISongService;
import org.example.ss8_songs_validate.validate.SongValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @Autowired
    private SongValidate songValidate;

    // ===== ADD =====
    @GetMapping("/")
    public String showFormAdd(Model model) {
        model.addAttribute("song", new Song());
        return "index";
    }

    @PostMapping("/add")
    public String save(
            @Valid @ModelAttribute("song") Song song,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        songValidate.validate(song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công 🎉");
        return "redirect:/result";
    }

    // ===== UPDATE =====
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "update";
    }

    @PostMapping("/update")
    public String update(
            @Valid @ModelAttribute("song") Song song,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        songValidate.validate(song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update";
        }
        songService.update(song);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công 🎉");
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }
}
